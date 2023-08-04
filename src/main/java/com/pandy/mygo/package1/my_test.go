package package1

import "testing"
import "fmt"

func Test1(t *testing.T) {
	const (
		a = iota
		b = iota
	)
	const (
		name = "menglu"
		c    = iota
		d    = iota
	)

	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	fmt.Println(d)

}