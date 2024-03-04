package main

type Set map[int]bool

func (s Set) Add(element int) {
	s[element] = true
}

func (s Set) Remove(element int) {
	delete(s, element)
}

func (s Set) Contains(element int) bool {
	_, exists := s[element]
	return exists
}

func main() {
	set := make(Set)

	set.Add(1)
	set.Add(2)
	set.Add(2)

	set.Remove(2)

	println(set.Contains(1))
	println(set.Contains(2))
}
