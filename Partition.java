import java.util.InputMismatchException;
import java.util.Scanner;

public class Partition
{
PartitionObject[] partition;
int partitionSize;
String stratgy;
int startingAddress=0;
int endingAddress;
int internalFrag;


public Partition(int sizeAr)
{
    Scanner scan = new Scanner(System.in);
    partition = new PartitionObject[sizeAr];
for (int i=0 ; i<sizeAr ;i++) {
    System.out.println("size");
    int size = scan.nextInt();
    partition[i] = new PartitionObject(size, startingAddress);
    startingAddress+=size;
}
    stratgy = scan.next();
    scan.close();

}

public void Allocate(String stratgy,String pId, int pSize)
{
    switch (stratgy.toLowerCase().charAt(0)) {
       
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
            System.out.println("Invalid stratgy");
        }



}


public void Deallocate(String id)
{
boolean isfound = false;
		for (int i = 0; i < partition.length; i++) {
			if (partition[i].getProcessId().equals(id)) {
				partition[i].setPartitionStatus(false);
				partition[i].setProcessId(null);
				isfound = true;
				//partition[i].setpartitionSize(-1);
			}
		}


}

public void Report()
{
for(int i=0;i<partition.length;i++){
   if(partition[i].isPartitionStatus()==false)
      System.out.println("size of partition is: "+partition[i].getPartitionSize()+" patition status is: Allocate "+" process Number is: "+partition[i].getProcessId()+" Starting Adddres: "+partition[i].getStartingAddress()+" Ending Adddres: "+partition[i].getEndingAddress()+" InternalFragmentation is: "+(partition[i].getPartitionSize()-partition[i].getProcessSize()) );
   else
    System.out.println("size of partition is: "+partition[i].getPartitionSize()+" patition status is: Free "+" process Number is: Null "+" Starting Adddres: "+partition[i].getStartingAddress()+" Ending Adddres: "+partition[i].getEndingAddress()+" InternalFragmentation is: -1");
    
}
 
}

public void WorstFit(String id,int size)
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
        System.out.println("done allocate");}
      else
       System.out.println("can not allocate"); 
}

public void BestFit(String id,int size)
{
int BigEnough = -1;
int MemorySearch = partition.length;
System.out.println("54534535347");

for (int i = 0 ; i < MemorySearch ; i++)//Search the smallest hole is big enough 
 {
    System.out.println("5667");
	if (partition[i].isPartitionStatus()==true && size <= partition[i].getPartitionSize()) 
        {
            System.out.println("0");
           if(BigEnough == -1){
            System.out.println("1"); //for first process to compare between other proceses to find smallest hole
             BigEnough = i;}
           else if(partition[i].getPartitionSize() < partition[BigEnough].getPartitionSize()){
            System.out.println("2");
	     BigEnough = i;}
	 }
   }
   System.out.println("3");

 if (BigEnough != -1){
 partition[BigEnough].allocate(id,size);
 System.out.println("done allocate");
   }
 else{
 System.out.println("Can not allocate");
}
System.out.println("4");
}
public void FirstFit(String id,int size)
{
for (PartitionObject partitionObject : partition) {
    if (partitionObject.getPartitionSize()>=size&&partitionObject.isPartitionStatus()) {
        partitionObject.allocate(id, size);
        System.out.println("done allocate");
        break;
    }
    System.out.println("cant allocate");
}



}

}
