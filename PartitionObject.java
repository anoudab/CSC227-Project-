public class PartitionObject {
    private String processId;
    private int processSize;
    private int partitionSize;
    private boolean partitionStatus;
    private int startingAddress;
    private int endingAddress;

    public PartitionObject(int size, int starting){
        processId = "Null";
        processSize = 0;
        partitionSize = size;
        partitionStatus = true;
        startingAddress = starting;
        endingAddress = size+starting;
    }
    public void allocate(String id, int size){
        processId = id;
        processSize = size;
        partitionStatus = false;
    }
    public int getProcessSize() {
        return processSize;
    }
    public void setProcessSize(int processSize) {
        this.processSize = processSize;
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
    public String getProcessId() {
        return processId;
    }
    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
