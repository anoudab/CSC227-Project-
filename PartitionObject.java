public class PartitionObject {
    private int processId;
    private int partitionSize;
    private boolean partitionStatus;
    private int startingAddress;
    private int endingAddress;

    public PartitionObject(int size, int starting){
        processId = 0;
        partitionSize = size;
        partitionStatus = false;
        startingAddress = starting;
        endingAddress = size+starting;
    }

    public int getPartitionSize() {
        return partitionSize;
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
    public int getEndingAddress() {
        return endingAddress;
    }
    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
