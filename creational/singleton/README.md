# Singleton Design Pattern

1. [The Problem](README.md#1-the-problem)

    1.1. [Shared Resource](README.md#11-shared-resource)
   
    1.2. [Single Access Point](README.md#12-single-access-point)

2. [The Solution](README.md#2-the-solution)
   
    2.1. [Constructor Hiding](README.md#21-constructor-hiding) 
    
    2.2. [Global Access Point](README.md#22-global-access-point) 

3. [The Code](README.md#3-the-code)

    3.1. [Simple Singleton](README.md#31-simple-singleton)
    
    3.2. [Thread-safe Singleton](README.md#32-thread-safe-singleton)
   
    3.3. [Double-checked Locking](README.md#33-double-checked-locking)
   
    [Summary](README.md#summary)

---

## 1. The Problem

### 1.1 Shared Resource
Imagine you have a class that is responsible 
for managing the database connection. You want
to make sure that only one instance of this class
exists in your application. If you create multiple
instances of this class, you will end up with 
multiple database connections, which is not what
you want.

Similarly, there can be a class that is 
responsible for managing the logging mechanism.
You want to make sure that only one instance of
this class exists in your application. If you 
create multiple instances of this class, you 
will end up with multiple log files, which is
not what you want.

### 1.2 Single Access Point
Applications often require configuration.
For example, you might want to configure the 
database connection parameters. 
You want to make sure that only one instance of
this class exists in your application. 
A configuration class should have a single access
point to the configuration parameters. 
If you create multiple instances of this class,
you will end up with multiple configuration
files.

## 2. The Solution

The Singleton pattern is a creational 
design pattern that lets you ensure that a class
has only one instance, while providing a global
access point to this instance.

In order to implement the Singleton pattern, 
we need to follow these requirements:

### 2.1 Constructor hiding

The constructor of the singleton class should
be private or protected. This will prevent
other classes from instantiating the singleton 
class.

### 2.2 Global access point

The singleton class should provide a global
access point to get the instance of the 
singleton class. This global access point 
should be static and should return the same
instance of the singleton class everytime it 
is called. If the instance does not exist, it
should create the instance and then return it.

## 3. The Code

Let's explore different techniques in which we
can achieve the Singleton design pattern.

- 3.1 Simple Singleton 
- 3.2 Thread-safe Singleton
- 3.3 Singleton using Double-checked Locking

### 3.1 Simple Singleton

<span style="color:white; background-color:#555; border-radius:12px; padding:4px"><b>Step 1 :</b></span>

As we already know that we need to hide the 
constructor so that the other classes 
should not be able to instantiate the singleton
class. We will do this by making it private.

```java
public class Database {
    private Database() {}
}
```
<span style="color:white; background-color:#555; border-radius:12px; padding:4px"><b>Step 2 :</b></span>

The above code restricts the instantiation of
the `Database` class. Now, we need to provide
a global access point to get the instance of the
`Database` class. We can do this by creating a static
method that returns the instance of the `Database` class.
If the instance does not exist, it should create the 
instance and then return it.

```java
public class Database {
    private static Database instance = new Database();
    
    private Database() {}
    
    public static getInstance() {
        return instance;
    }
}
```

To implement the `getInstance()` method, we need to create a 
static variable of the `Database` class. This variable will
hold the instance of the Database class. We will initialize
this variable to null. The `getInstance()` method will check
if the instance variable is null. If it is null, it will 
create a new instance of the `Database` class and assign it
to the `instance` variable. 
This is known as lazy _initialization_.

```java
public class Database() {
    private static Database instance = new Database();
    
    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
```

## 3.2 Thread-safe Singleton

The above code is not thread-safe. If two threads call
`getInstance()` method at the same time, both threads will
if the instance variable is null. Both threads will find
create a new instance of the `Database` class. To make the 
above code thread-safe, we can make the `getInstance()` method
`synchronized`.

```java
public class Database {
    private static Database instance = null;
    
    private Database() {}
    
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();           
        }
        return instance;    
    }
}
```

## 3.3 Double-checked locking

The above code is thread-safe however, it is not efficient.
If the two threads call the `getInstance()` method at the 
same time, both threads will check if the instance variable
is null. Both threads will find that the instance variable
is null. Both threads will wait for the lock to be released.

Once the lock is released, one thread will create a new 
instance of the `Database` class. The other thread will 
wait for the lock to be released. Once the lock is released,
it will create a new instance of the `Database` class.
This will result in two instances of `Database` class. 
To make the above code efficient, we can use double-checked
locking.

```java

public class Database {
    private static Database instance = null;
    
    private Database() {}
    
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) { 
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
}
```

## Summary

- The Singleton pattern is a creational design pattern that
    lets you ensure that a class has only one instance, 
    while providing a global access point to this instance.
- Use cases of singleton pattern
  - Shared resources like database 
    connection, logging mechanisms, etc.
  - Object that should be instantiated only once like
    configuration object.
- Add a static method that returns the instance of the 
    singleton class. If the instance does not exist, it 
    should create the instance and then return it.
- Thread safety
    - Make `getInstance()` method `synchronized`.
    - Use Double-checked Locking.