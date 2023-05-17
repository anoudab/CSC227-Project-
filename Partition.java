import java.util.InputMismatchException;

public class Partition
{

int partitionSize;
int startingAddress;
int endingAddress;
int internalFrag;


public Partition()
{

}

public void Allocate(String stratgy,String pName, int pSize)
{
    switch (stratgy.toLowerCase().charAt(0)) {
        case 'b':
            BestFit(pName, pSize);
            break;
    
        case 'w':
            WorstFit(pName, pSize);
            break;

        case 'f':
            FirstFit(pName, pSize);
            break;
        default:
            System.out.println("Invalid stratgy");
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input");
        break;
    }


}


public void Deallocate(String id)
{
boolean isfound = false;
		for (int i = 0; i < partition.length; i++) {
			if (partition[i].getProcessId().equals(id)) {
				partition[i].setPartitionStatus(false);
				partition[i].setProcessId(0);
				isfound = true;
				partition[i].setpartitionSize(-1);
			}
		}


}

public void Report()
{

}

public void WorstFit()
{

}

public void BestFit()
{

}

public void FirstFit()
{

}





}