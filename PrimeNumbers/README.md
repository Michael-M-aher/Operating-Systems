# Prime Numbers Generator
<img src="https://user-images.githubusercontent.com/25803558/228936159-db358383-6a06-49c5-a299-0e9bbae622db.png">

## Brief

This is a GUI program written in Java that generates prime numbers within a given range, using a producer-consumer pattern with synchronization. The program allows the user to specify the range of prime numbers to generate, the buffer size for the producer-consumer queue, and the filename to save the generated primes to.

## Features

- Generates prime numbers in a given range using a producer-consumer pattern with synchronization
- Gives you the largest prime number, number of primes and the time taken by program.
- Allows the user to specify the buffer size for the producer-consumer queue
- Saves the generated prime numbers to a file specified by the user

## Usage

1. Clone the repository or download the ZIP file.
2. Open the project in your preferred Java IDE (e.g. Eclipse, IntelliJ, NetBeans).
3. Build and run the project.
4. The GUI window will open, prompting the user to input the range of prime numbers to generate, the buffer size, and the filename to save the primes to.
5. Once the user inputs the required information, they can click the "Generate Primes" button to start the prime number generation process.
6. The program will output the generated primes and save them to the specified file.

## Requirements

- Java Development Kit (JDK) 8 or later
- Java IDE (e.g. Eclipse, IntelliJ, NetBeans)

## Code Structure

The program consists of the following Java classes:

- `PrimeNumberGenerator`: Contains the main logic for generating prime numbers using a producer-consumer pattern with synchronization.
- `PrimeNumberProducer`: Implements the producer side of the producer-consumer pattern.
- `PrimeNumberConsumer`: Implements the consumer side of the producer-consumer pattern.
- `primeNumber`: Represents a prime number.
- `primeNumberBuffer`: Implements a thread-safe buffer for the producer-consumer pattern.
