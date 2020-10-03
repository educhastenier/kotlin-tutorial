package com.bonitasoft.watch.kotlin.corelang.designpatterns

class UncertainAnimal {
    // makeSound here is a variable of type "function"
    // defining it as "var" allows override:
    var makeSound = fun() = "Meow!"
}
