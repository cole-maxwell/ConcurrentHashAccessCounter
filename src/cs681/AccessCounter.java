package cs681;
import java.util.HashMap;
import java.util.concurrent.locks.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccessCounter {

	private static AccessCounter instance = null;
	private HashMap<java.nio.file.Path, Integer> accessCounter =
								new HashMap<java.nio.file.Path, Integer>();

	public AccessCounter() {}

	public static AccessCounter getInstance() {
			if(instance==null) {
				instance = new AccessCounter();
			}
			return instance;
	}

	public void increment(Path path) {
		
		Integer oldCount = accessCounter.get(path);
		int newCount = oldCount==null? 1: oldCount+1;
		accessCounter.put(path, newCount);
	}

	public Integer getCount(Path path) {
		
		if(this.accessCounter.containsKey(path)){
			System.out.println("getcount(): <" + path + "> has been accessed " + this.accessCounter.get(path) + " times");
			return this.accessCounter.get(path);
		}
		else {
			return 0;
		}
	}	
}
