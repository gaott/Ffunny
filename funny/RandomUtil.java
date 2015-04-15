package funny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomUtil {
	
	/**
	 * 从1~9取一个随机数
	 * @return
	 */
	public static int getUnitRandom(){
		int random = new Random().nextInt(9);
		return  random == 0 ? getUnitRandom() : random;
	}
	
	/**
	 * 取一个指定长度的随机数
	 * 
	 * @param length
	 * @return
	 */
	public static int getRandomNum(int length){
		int num = getUnitRandom();
		for(int i = 2; i <= length; i++){
			num = num + (int)Math.pow(10, i - 1) * getUnitRandom();
		}
		
		return num;
	}
	
	/**
	 * 取一个指定长度的随机数组
	 * 
	 * @param length 长度
	 * @param count 随机数个数
	 * @return
	 */
	public static List<Integer> getRandomArray(int length, int count){
		List<Integer> randomArray = new ArrayList<Integer>(count);
		
		int countLength = String.valueOf(count).length();
		
		// 当随机数长度小于数组长度相等时，不符合逻辑
		if (length < countLength) {
			throw new NullPointerException();
		}
		
		// 当随机数长度与数组长度相等时，
		if (length == countLength) {
			
			// 当随机数长度与数组长度相差小于10，不符合逻辑
			if (length != 1 && (int)Math.pow(10, length) - count < 10) {
				throw new NullPointerException();
			}
			
			// 生成有序数组
			for (int i = 0;i < count; i++) {
				randomArray.add(i + (int)Math.pow(10, length - 1));
			}
		} else {
			for (int i = 1; i <= count; i++) {
				// 补差位
				int diffUnitNum = getRandomNum(length - countLength) * (int)Math.pow(10, countLength);
				// i，尾数
				randomArray.add(i + diffUnitNum);
			}
		}
		
		Collections.shuffle(randomArray);
		return randomArray;
	}

	public static void main(String[] args) {
		
		System.out.println(getRandomNum(2));
		List<Integer> a = getRandomArray(6, 5);
		System.out.println(a);
		System.out.println(new HashSet<Integer>(a).size());
	}
}
