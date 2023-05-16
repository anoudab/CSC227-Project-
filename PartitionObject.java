public class PartitionObject {
    private int partitionSize;
    private boolean partitionStatus;
    private int startingAddress;
    private int endingAddress;

    public PartitionObject(int size, int starting){
        partitionSize = size;
        partitionStatus = false;
        startingAddress = starting;
        endingAddress = size+starting;
    }

    public int getPartitionSize() {
        return partitionSize;
    }
    public void setPartitionSize(int partitionSize) {
        this.partitionSize = partitionSize;
    }
    public boolean isPartitionStatus() {
        return partitionStatus;
    }
    public void setPartitionStatus(boolean partitionStatus) {
        this.partitionStatus = partitionStatus;
    }
    public int getStartingAddress() {
        return startingAddress;
    }
    public void setStartingAddress(int startingAddress) {
        this.startingAddress = startingAddress;
    }
    public int getEndingAddress() {
        return endingAddress;
    }
    public void setEndingAddress(int endingAddress) {
        this.endingAddress = endingAddress;
    }
}
