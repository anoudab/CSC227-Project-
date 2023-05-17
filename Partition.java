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
				partition[i].setpartitionSize(-1);
			}
		}


}

public void Report()
{

}

public void WorstFit(String id,int size)
{

}

public void BestFit(String id,int size)
{

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
