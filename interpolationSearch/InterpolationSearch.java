package interpolationSearch;

/** Searching in the general area where the target will be. Think of as a phone book, you may know that the name/target you are looking for will be under the letter M,...
* ...so you may InterpolationSeach using this knowledge.
* x2, y2 is the (x,y) of the highest/last part of the list. x1, y1 is the (x,y) of the lowest/first part of the list.
* And our point (target/value) that we are trying to find, our x,y which  is the target. We know/have the x, but don't know the y.
* Remember on the graph: x represents targetValue/list[i]....and y represents i/index. We know the x but are looking for the y.
* Our y2 (index #)is equal to our 'high', y1 (index #)is equal to our 'low', list[high] means we want to get value of highest index in the list that we're searching...
* ...and we subtract from the lowest index list[low] which represents x1 so we subtract x - x1 meaning subtracting targetValue - value of the lowest index. 
* so now were on code line 23 where all were doing is everything above by using the variable to divide rise & run and multiply x, and the only new thing were adding...
* ...now besides what we talked about above is the + low;...
* ...and we get the index, in the if else statements we then go and check against it..see what happens and get our solution.
*/
public class InterpolationSearch {
	boolean interpolationSearchMethod(int[] list, int size, int targetValue) {
		boolean foundIndex = false;   						//just to check if we did find the number, this will change from false to true if found, else if not it will remain false.
		int low = 0, high = list.length-1;
		int count = 0;
		
		while (list[high] >= targetValue && list[low] < targetValue) {
			//y=mx + b:     y - y1= m(x + x1)   ->   y = m(x - x1) + y1    ->     y = y2-y1/x2-x1 * (x - x1) + y1
			int rise = high - low; 			   					// y2 - y1 //Rise over run. y2 represents the index number //highest index # subtracted by lowest index #.
			int run = list[high] - list[low];  					// x2 - x1
			int x = targetValue - list[low];   					// (x - x1)
			
			int index = (rise / run) * x + low; 
			
			if (targetValue < list[index]) {
				high = index - 1;
			}else if (targetValue > list[index]) {
				low = index +1;
			}else {
				low = index;
				
				System.out.println("Iteration #: " + ++count);    //only took 1 iteration, super fast!
			}
			
		}
		if (list[low] == targetValue) {  						  //just to check if we did find the number, that we can change boolean to true from false, else it will show false.
			foundIndex = true;
			//System.out.println(list[high]);					  why is high at 1009?? and not 1000?
		}
		
		return foundIndex;
}
	
	public static void main(String arg[]) {
		int list[] = new int[1000];
		for (int i = 0; i < 1000; i++) {
			list[i] = (i + 10);	
		}
		InterpolationSearch ipObj = new InterpolationSearch();
		System.out.println(ipObj.interpolationSearchMethod(list, 1000, 1002));
	}

} 


