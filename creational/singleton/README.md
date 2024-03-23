# Singleton Design Pattern

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
class Database {
    private Database() {
        
    }
}
```
<span style="color:white; background-color:#555; border-radius:12px; padding:4px"><b>Step 2 :</b></span>

The above code restricts the instantiation of
the `Database` class. Now, we need to provide
a global access point

