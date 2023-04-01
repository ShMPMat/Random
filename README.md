# Tashtabash Random

This is a small library with a number of functions working with randomness.

## Structure

There are two types of functions defined in two packages:

- `io.tashtabash.random` - use explicitly provided `kotlin.random.Random`;
- `io.tashtabash.random.singleton` implicitly use `Random` from `io.tashtabash.random.singleton.RandomSingleton`, 
which has to be initialized at the start of your app; tightly coupled but more DSL-like.

## Examples

Initialize RandomSingleton

    RandomSingleton.safeRandom = Random(0)

Execute code with 20% chance

    0.2.chanceOf { 
        // Your code
    }

Choose an element at random with some chance

    val e: Int = listOf(2, 3, 4).randomElement { 
        1.0 / it
    }

## Contacts

[matveyshnytkin@gmail.com](mailto:matveyshnytkin@gmail.com)