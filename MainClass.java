import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class MainClass
{

   static PartitionObject[] partition;
   static String memoryApproach;


 public static void main(String args[])
 {

   System.out.println("--------------------------------------------------------------");
   System.out.println("Welcome to the Memory Managemnet System!");
   System.out.println("--------------------------------------------------------------");

   Scanner scan = new Scanner(System.in);
   

     System.out.println("To create a new memory, please enter the following:");
     System.out.print("Enter the number of partitions for the memory: ");
     int m = scan.nextInt();
     partition = new PartitionObject[m];


     System.out.println("Enter the size of each partition: ");
     int startingAddress = 0;
     int size = 0;
     String processID;
   
     for(int i = 0; i < m; i++)
       {
           System.out.print("Size of partition " + (i+1) + ": ");
           size = scan.nextInt();
           startingAddress += size;
           partition[i] = new PartitionObject(size, startingAddress);
           processID = "P" + (i+1);
           partition[i].setProcessId(processID);
                      
          }
       

     System.out.println("Please enter a memory allocation approach:");
     System.out.println("Choose 'F' for First Fit / 'B' for Best Fit / 'W' for Worst Fit: ");
     memoryApproach = scan.next(); 

   System.out.println("Memory created successfully!");
   System.out.println("--------------------------------------------------------------");

   System.out.println("You can now manage your memory!");
   System.out.println("Choose '1' to allocate a process / Choose '2' to deallocate a process / Choose '3' to print a report / Choose '4' to exit the program.");

   int input = 0;

   do
   {

      System.out.print("Enter your choice: ");
      input = scan.nextInt();

        switch(input)
         {
            case 1:
            System.out.print("Enter the process ID and the size: ");
            String processId1 = scan.next();
            int processSize = scan.nextInt();
            Allocate(processId1, processSize);
            break;

            case 2:
            System.out.print("Enter the process ID you wish to deallocate:");
            String processId2 = scan.next();
            Deallocate(processId2);
            break;

            case 3:
            try
            {
            Report();
            }
            catch(IOException e)
            { 
            System.out.println("Error: Could not print report.");
            }
            break;

            default:
            System.out.println("Please only choose one of the numbers from the menu.");

         }

    } while ( input != 4 );


   System.out.println("--------------------------------------------------------------");
   System.out.println("Thank you for using the Memory Management System! We hope you enjoyed!");
   System.out.println("--------------------------------------------------------------");

   scan.close();

}


public static void Allocate(String pId, int pSize)
{

   switch (memoryApproach.toLowerCase().charAt(0)) 
   {
        case 'f':
        FirstFit(pId, pSize);
        break;

        case 'b':
        BestFit(pId, pSize);
        break;

        case 'w':
        WorstFit(pId, pSize);
        break;

        default:
        System.out.println("Error: allocation method not found.");
    }


//print memory look


}

public static void Deallocate(String id)
{
boolean isfound = false;
		for (int i = 0; i < partition.length; i++) {
			if (partition[i].getProcessId().equals(id)) {
				partition[i].setPartitionStatus(true);
				partition[i].setProcessId(null);
				isfound = true;
				//partition[i].setPartitionSize(-1);
			}
		}


}


public static void WorstFit(String id,int size)
{
int worst=-1;
for(int i=0;i<partition.length;i++){
    if(partition[i].isPartitionStatus()==true && partition[i].getPartitionSize()>size){
         if(worst==-1)
            worst=i;
         else if(partition[i].getPartitionSize()>partition[worst].getPartitionSize())
              worst=i;}}
      if(worst!=-1){
        partition[worst].allocate(id,size);
        System.out.println("Allocated successfully!");}
      else
       System.out.println("Error: Can not allocate"); 
}


public static void BestFit(String id, int size)
{

int BigEnough = -1;
int MemorySearch = partition.length;

for (int i = 0 ; i < MemorySearch ; i++) //Search the smallest hole is big enough 
 {
	if (partition[i].isPartitionStatus()==true && size <= partition[i].getPartitionSize()) 
        {
           if(BigEnough == -1) //for first process to compare between other proceses to find smallest hole
             BigEnough = i;
           else if(partition[i].getPartitionSize() < partition[BigEnough].getPartitionSize())
	     BigEnough = i;
	 }
   }

 if (BigEnough != -1){
 partition[BigEnough].allocate(id,size);
 System.out.println("Allocated Successfully!");
   }
 else
 System.out.println("Error: Can not allocate");
 
}

public static void FirstFit(String id,int size)
{
for (PartitionObject partitionObject : partition) {
    if (partitionObject.getPartitionSize()>=size&&partitionObject.isPartitionStatus()) {
        partitionObject.allocate(id, size);
        System.out.println("Allocated successfully!");
        break;
    }
    System.out.println("Error: Can not allocate");
}



}

public static void Report() throws IOException {

System.out.println("--------------------------------------------------------------");
System.out.println("Current State of the Memory");
System.out.println("--------------------------------------------------------------");

for(int i=0;i<partition.length;i++){
     System.out.println("Partition " + (i+1) + ":");
   if(partition[i].isPartitionStatus()==false)
      {
       System.out.println(" The Size of partition is: " + partition[i].getPartitionSize() + "\n The partition status is: Allocate " + "\n The process number is: " + partition[i].getProcessId() + "\n The starting adddres is: "+ partition[i].getStartingAddress() + "\n The ending adddres: " + partition[i].getEndingAddress() + "\n The internal fragmentation is: " + (partition[i].getPartitionSize()-partition[i].getProcessSize()) );
      }
   else
    System.out.println(" The size of partition is: " + partition[i].getPartitionSize() + "\n The partition status is: Free "+" \n The process number is: Null " + " \n The starting adddres is: " + partition[i].getStartingAddress()+"\n The ending adddres is: " + partition[i].getEndingAddress() + "\n The internal fragmentation is: -1");
    
    
    
        FileWriter writer = new FileWriter("Report.txt");
        writer.write("----------------------------");
        writer.write("Report for the memory:");
        writer.write("----------------------------");

    		for(int j=0;j<partition.length;j++){
         writer.write("Partition " + (i+1) + ":");
         if(partition[i].isPartitionStatus()==false)
         {
         writer.write(" The Size of partition is: " + partition[i].getPartitionSize() + "\n The partition status is: Allocate " + "\n The process number is: " + partition[i].getProcessId() + "\n The starting adddres is: "+ partition[i].getStartingAddress() + "\n The ending adddres: " + partition[i].getEndingAddress() + "\n The internal fragmentation is: " + (partition[i].getPartitionSize()-partition[i].getProcessSize()) ); 
			}
         else
         writer.write(" The size of partition is: " + partition[i].getPartitionSize() + "\n The partition status is: Free "+" \n The process number is: Null " + " \n The starting adddres is: " + partition[i].getStartingAddress()+"\n The ending adddres is: " + partition[i].getEndingAddress() + "\n The internal fragmentation is: -1");
         }
         
         writer.close();
    
    
}
 
}



}
