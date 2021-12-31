package main

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		another := target - nums[i]
		if _, ok := m[another]; ok {
			// 找到了直接返回 索引
			return []int{m[another], i}
		}
		// 没有找到将值作为键存入 索引所谓值存入
		m[nums[i]] = i
	}
	return nil
}

func main() {
	var nums = []int{1, 2, 3, 4, 5, 6}
	var target = 7
	sum := twoSum(nums, target)
	for _, i := range sum {
		println(i)
	}
}
