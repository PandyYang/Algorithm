-- 各个视频的平均完播率
select u.video_id,
       round(
               sum(if(end_time - start_time >= duration, 1, 0)) / count(u.video_id),
               3
           ) as avg_comp_play_rate
from tb_user_video_log u
         left join tb_video_info v on u.video_id = v.video_id
where
    year (start_time) = 2021
group by
    u.video_id
order by
    avg_comp_play_rate desc;


--  平均播放进度大于60%的视频类别
select tag,
       CONCAT(avg_play_progress, "%") as avg_play_progress
from (
         select tag,
                ROUND(
                            avg(
                                    if(
                                            timestampdiff(second, start_time, end_time) > duration,
                                            1,
                                            timestampdiff(second, start_time, end_time) / duration
                                        )
                                ) * 100,
                            2
                    ) as avg_play_progress
         from tb_video_info a
                  join tb_user_video_log b on a.video_id = b.video_id
         group by tag
         having avg_play_progress > 60
         order by avg_play_progress desc
     ) as xx
