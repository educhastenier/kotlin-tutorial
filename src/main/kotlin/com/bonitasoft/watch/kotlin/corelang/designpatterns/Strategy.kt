package com.bonitasoft.watch.kotlin.corelang.designpatterns

// The strategy pattern is used to create an interchangeable family of algorithms
// from which the required implementation is chosen at run-time.

class UncertainAnimal {
    // makeSound here is a variable of type "function"
    // defining it as "var" allows override:
    var makeSound = fun() = "Meow!"
}
