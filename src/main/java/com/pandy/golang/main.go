package main

import (
	"fmt"
	"math/rand"

	"strings"
	"sync"
	"unicode"
)

func main() {

	// 交替打印数字和字母
	// 使用两个 goroutine 交替打印序列，一个 goroutine 打印数字， 另外一个 goroutine 打印字母， 最终效果如下：
	// 12AB34CD56EF78GH910IJ1112KL1314MN1516OP1718QR1920ST2122UV2324WX2526YZ2728

	letter, number := make(chan bool), make(chan bool)

	wait := sync.WaitGroup{}

	go func() {
		i := 1
		for {
			select {
			case <-number:
				fmt.Print(i)
				i++
				fmt.Print(i)
				i++
				letter <- true
			}
		}
	}()

	go func(wait *sync.WaitGroup) {
		i := 'A'
		for {
			select {
			case <-letter:
				if i >= 'Z' {
					wait.Done()
					return
				}

				fmt.Print(string(i))
				i++
				fmt.Print(string(i))
				i++
				number <- true
			}
		}
	}(&wait)

	// 想要数字和字母开头 先激活哪个
	number <- true

	// wait用于控制主进程不退出
	// 以数字和字母谁结尾 则在其中wg.Done()
	wait.Add(1)
	wait.Wait()
}

// 判断字符串中字符是否全都不同
// 请实现一个算法，确定一个字符串的所有字符【是否全都不同】。这里我们要求【不允许使用额外的存储结构】。
// 给定一个string，请返回一个bool值,true代表所有字符全都不同，false代表存在相同的字符。
// 保证字符串中的字符为【ASCII字符】。字符串的长度小于等于【3000】。
func isUniqueString(s string) bool {
	if strings.Count(s, "") > 3000 {
		return false
	}

	for _, v := range s {
		if v > 127 {
			return false
		}

		if strings.Count(s, string(v)) > 1 {
			return false
		}
	}
	return true
}

// 使用strings.Index 和 strings.LastIndex
func isUniqueString2(s string) bool {
	if strings.Count(s, "") > 3000 {
		return false
	}

	for k, v := range s {
		if v > 127 {
			return false
		}

		// Index会取到字符第一次出现的位置
		if strings.Index(s, string(rune(k))) != k {
			return false
		}
	}

	return true
}

// 翻转字符串
// 请实现一个算法，在不使用【额外数据结构和储存空间】的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
// 给定一个string，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
func reverseString(s string) (string, bool) {
	str := []rune(s)
	l := len(str)
	if l > 5000 {
		return s, false
	}

	for i := 0; i < l/2; i++ {
		str[i], str[l-1-i] = str[l-1-i], str[i]
	}

	return string(str), true
}

// 判断两个给定的字符串排序后是否一致
// 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 这里规定【大小写为不同字符】，
// 且考虑字符串重点空格。给定一个string s1和一个string s2，请返回一个bool，代表两串是否重新排列后可相同。
// 保证两串的长度都小于等于5000。
func isRegroup(s1, s2 string) bool {
	sl1 := len([]rune(s1))
	sl2 := len([]rune(s2))

	if sl1 > 5000 || sl2 > 5000 || sl1 != sl2 {
		return false
	}

	for _, v := range s1 {
		if strings.Count(s1, string(v)) != strings.Count(s2, string(v)) {
			return false
		}
	}
	return true
}

// 字符串替换问题
// 请编写一个方法，将字符串中的空格全部替换为“%20”。 假定该字符串有足够的空间存放新增的字符，
// 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由【大小写的英文字母组成】。
// 给定一个string为原始的串，返回替换后的string。
func replaceBlack(s string) (string, bool) {
	if len([]rune(s)) > 1000 {
		return s, false
	}

	for _, v := range s {
		if string(v) != " " && unicode.IsLetter(v) == false {
			return s, false
		}
	}

	return strings.Replace(s, " ", "%20", -1), true
}

func channelAndRoutine() {
	out := make(chan int)
	wg := sync.WaitGroup{}
	wg.Add(2)

	go func() {
		defer wg.Done()
		for i := 0; i < 5; i++ {
			out <- rand.Intn(5)
		}
		close(out)
	}()

	go func() {
		defer wg.Done()
		for i := range out {
			fmt.Println(i)
		}
	}()
	wg.Wait()
}