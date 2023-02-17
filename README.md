# os-assignment2-group1
Movie Ticket Server and Client  
Simon Gjøen  
Mark Kour 

## How to run the code
In IntelliJ: Access the Main class. Press the "play button" in the top right corner of the program.  
In other words, run Main.java (for other IDEs).

## Observations (Task 3)
### Before synchronization
Log:  
Hi,Ilaria : 10 : Seats available for Troll  
Hi,Andreas : 10 : Seats available for Troll  
Hi,Sam : 10 : Seats available for Troll  
Hi,Ilaria : 2 Seats booked successfully forTroll  
Hi,Andreas : 4 Seats booked successfully forTroll  
Hi,Sam : 3 Seats booked successfully forTroll  
Hi,Xiangming : 10 : Seats available for Troll  
Hi,Xiangming : Seats not available for Troll  

Process finished with exit code 0

The problem is the threads are accessing the same resource at the same time.  
They all get the message that 10 tickets are available, when in reality some  
of the tickets are already booked. For instance Xiangming is told that there   
are 10 available tickets, but then can't book because there are no seats  
available. We need to synchronize the accessing of the resource, so the  
customer booking, access the movie server one at a time.

### After synchronization
Log:  
Hi,Ilaria : 10 : Seats available for Troll  
Hi,Ilaria : 2 Seats booked successfully forTroll  
Hi,Andreas : 8 : Seats available for Troll  
Hi,Andreas : 4 Seats booked successfully for Troll  
Hi,Sam : 4 : Seats available for Troll  
Hi,Sam : 3 Seats booked successfully forTroll  
Hi,Xiangming : 1 : Seats available for Troll  
Hi,Xiangming : Seats not available for Troll  

Process finished with exit code 0
  
Now we see that it works, because only one thread can access the method "bookTicket"  
from the MovieTicketServer class at a time. This was done by making this method  
"synchronized". Then it simply won't allow more than one thread to access the  
method at a time. From the log we can see that Ilaria got two tickets first, which  
reduced the number to 8. Then Andreas got 4, which made it 4 left, then Sam got  
3 tickets. With only 1 left poor Xiangming didn't get any tickets with this  
implementation of MovieTicketServer either.

But when I ran the code again the order changed. Xiangming was first, then Andreas,  
then Sam, and Ilaria was last (and was denied tickets). This means that this way  
of synchronizing does not have a consistent method, when it comes to who will  
access the resource first. This should be kept in mind in case the order of  
accessing the method/resource is important.