package main

import (
	"fmt"
	"sync"
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
