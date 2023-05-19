# ReadMe File
## Project Title:
CSC227-Project
## Project Collaborators:
-	Adwa2011
-	NadaQQ
-	Joryalhassan
-	Dana1666
-	anoudab
## Project description: 
This project is for our CSC227: Operating Systems course. The goal of this project is to create a program that creates and manages a memory. The user will be able to create a fixed memory and choose how many partitions it contains. They will also choose the size for each partition of the memory, and the memory allocation approach (First-Fit, Best-Fit, and Worst-Fit). The user will then interact with a menu that will give them the ability to allocate a process into the memory, deallocate a process, and print a report of the current memory. 
## Project Java Classes:
-	Memory Class: A class that contains the main method as well as the implementation for the allocate, deallocate, generate report, and the three memory allocation approach functions.
-	PartitionObject Class: A class that contains all the attributes, constructor, setters/getters for the partitions of the memory.
## Instructions on how to run the code: 
-	Run the “Main” method in the Memory class.
-	The program will start and display a welcome message.
-	The program will prompt the user to enter the size of the memory (number of partitions).
-	The program will prompt the user to enter the size of each partition, respectively.
-	The program will prompt the user to choose a memory allocation approach from the three listed.
-	A menu will pop up showcasing 4 options.
-	If “1 – Allocate a process” is chosen, the user is prompted to enter the Process ID and the size in KBs of the process that will be allocated. The program will also display the memory state after allocation, which shows the allocated processes and the available partitions.
-	If “2 – Deallocate a process” is chosen, the user is prompted to enter the Process ID of the process that will be deallocated.
-	If ”3 – Print a report” is chosen, the program will display on the console the status of the memory with the following information about each partition in the memory:
               - The size of partition in KBs.
               - The partition status (allocated or null). 
               - The process ID.
               -  The starting address in KBs.
               - The ending address in KBs.
               - The internal fragmentation in KBs (or -1 if there is none).
The program will also print a text file named “Report.txt” with the same information.
-	If “4 – Exit the Program” is chosen, the program will terminate with a farewell message.
