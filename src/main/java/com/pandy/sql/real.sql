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

-- 每类视频近一个月的转发量/率
select tag,
       sum(if_retweet),
       round(sum(if_retweet) / count(*), 3) as retweet_rate
from tb_user_video_log u
         join tb_video_info v on u.video_id = v.video_id
where timestampdiff(
          DAY, start_time,
               (
                   select max(start_time)
                   from tb_user_video_log
               )
          ) < 30
group by tag
order by retweet_rate desc;


-- 平均涨粉率

select v.author,
       date_format(u.start_time, '%Y-%m') month,
       round(sum(if(if_follow = 2, -1, if_follow)) / count(start_time), 3) as fans_growth_rate,
       sum(
               sum(if(if_follow = 2, -1, if_follow))
           )                                                                  over (partition by v.author order by date_format(u.start_time,'%Y-%m')) total_fans
from tb_user_video_log u
         inner join tb_video_info v
                    on u.video_id = v.video_id
where year (u.start_time) = '2021'
group by v.author, month
order by v.author,



select author,
       date_format(release_time, '%Y-%m') as month,
  round(sum(if(if_follow = 2, -1, if_follow)) / count(start_time), 3) as fans_growth_rate,
  sum(
      sum(if(if_follow = 2, -1, if_follow))
  ) over (partition by author order by date_format(u.start_time,'%Y-%m')) as total_fans
from
    tb_video_info v
    right join tb_user_video_log u
on v.video_id = u.video_id
where
    year (start_time) = 2021
  and year (end_time) = 2021
group by
    author, month
order by
    author, fans_growth_rate asc
