class minHeapTOmaxHeap {
    
    static void convertMinToMaxHeap(int N, int arr[]) {
        //bottom-up heapification
        for(int i=(N/2)-1;i>=0;i--){
            heapify(i,arr);
        }
    }
    
    static void heapify(int ind, int[] arr){
        //storing indices of left child and right child
        int left=2*ind+1;
        int right=2*ind+2;
        int largest=ind;
        //checking condition for left child
        if(left<arr.length && arr[largest]<arr[left]){
            largest=left;
        }
        //checking condition for right child
        if(right<arr.length && arr[largest]<arr[right]){
            largest=right;
        }
        //heapifying again
        if(largest!=ind){
            int temp=arr[ind];
            arr[ind]=arr[largest];
            arr[largest]=temp;
            if(largest<arr.length/2)
            heapify(largest,arr);
        }
    }
}