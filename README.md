# Java-Assesment-Test-Task2
Assesment test for an Internship - Java

I assumed that tasks are separate from each other and because of that I decided to create different data structures for different tasks - a new instance each time

For the task with comparing carts: 
because the cart link does not work, i assume that a cart instance has int- userID, and int[]- productIDs
example:
{ "userId": 7, "products:": [1,2,4,5,3,2,2,1,1] }

In the findHighestCartValueAndItsUser method I decided to allow passing an ArrayList of carts for testing purposes. Normally, the method should not take any arguments and just use DataRetriever.createCartList
