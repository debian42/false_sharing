package de.codecoverage;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 400, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1, time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend = {}) //"-XX:+PrintGCDetails", "-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintAssembly" , "-XX:PrintAssemblyOptions=intel"})
public class FalseSharingBenchmarks
{
	// This (static) mess lives in the "metaspace" of the JVM so jol can't see it
	// and I guessed the padding(and it can change) so it might not be optimal. 
	// Without volatile(lock prefix x86) the effect is not so visible. The cpu doesn't need to drain
	// the store buffer and can use store buffer forwarding
	static volatile long flushStoreBuffer1 = 0;
	static volatile long paddsb1_1 = 0, paddsb1_2 = 0, paddsb1_3 = 0, paddsb1_4 = 0, paddsb1_5 = 0, paddsb1_6 = 0, paddsb1_7 = 0, paddsb1_8;
	static volatile long flushStoreBuffer2 = 0;
	static volatile long paddsb2_1 = 0, paddsb2_2 = 0, paddsb2_3 = 0, paddsb2_4 = 0, paddsb2_5 = 0, paddsb2_6 = 0, paddsb2_7 = 0, paddsb2_8;
	static volatile long flushStoreBuffer3 = 0;
	static volatile long paddsb3_1 = 0, paddsb3_2 = 0, paddsb3_3 = 0, paddsb3_4 = 0, paddsb3_5 = 0, paddsb3_6 = 0, paddsb3_7 = 0, paddsb3_8;
	static volatile long flushStoreBuffer4 = 0;
	static volatile long paddsb4_1 = 0, paddsb4_2 = 0, paddsb4_3 = 0, paddsb4_4 = 0, paddsb4_5 = 0, paddsb4_6 = 0, paddsb4_7 = 0, paddsb4_8;
	static volatile long flushStoreBuffer5 = 0;
	static volatile long paddsb5_1 = 0, paddsb5_2 = 0, paddsb5_3 = 0, paddsb5_4 = 0, paddsb5_5 = 0, paddsb5_6 = 0, paddsb5_7 = 0, paddsb5_8;
	static volatile long flushStoreBuffer6 = 0;
	static volatile long paddsb6_1 = 0, paddsb6_2 = 0, paddsb6_3 = 0, paddsb6_4 = 0, paddsb6_5 = 0, paddsb6_6 = 0, paddsb6_7 = 0, paddsb6_8;
	static volatile long flushStoreBuffer7 = 0;
	static volatile long paddsb7_1 = 0, paddsb7_2 = 0, paddsb7_3 = 0, paddsb7_4 = 0, paddsb7_5 = 0, paddsb7_6 = 0, paddsb7_7 = 0, paddsb7_8;
	static volatile long flushStoreBuffer8 = 0;
	static volatile long paddsb8_1 = 0, paddsb8_2 = 0, paddsb8_3 = 0, paddsb8_4 = 0, paddsb8_5 = 0, paddsb8_6 = 0, paddsb8_7 = 0;
	
	static long lng0 = 0;
	static long lng1 = 0;
	static long lng2 = 0;
	static long lng3 = 0;
	static long lng4 = 0;
	static long lng5 = 0;
	static long lng6 = 0;
	static long lng7 = 0;
	
	static long counter = 0;
	
	static long clng0 = 0;
	static long padd1_1 = 0, padd1_2 = 0, padd1_3 = 0, padd1_4 = 0, padd1_5 = 0, padd1_6 = 0, padd1_7 = 0, padd1_8 = 0;
	static long clng1 = 0;
	static long padd2_1 = 0, padd2_2 = 0, padd2_3 = 0, padd2_4 = 0, padd2_5 = 0, padd2_6 = 0, padd2_7 = 0, padd2_8 = 0;
	static long clng2 = 0;
	static long padd3_1 = 0, padd3_2 = 0, padd3_3 = 0, padd3_4 = 0, padd3_5 = 0, padd3_6 = 0, padd3_7 = 0, padd3_8 = 0;
	static long clng3 = 0;
	static long padd4_1 = 0, padd4_2 = 0, padd4_3 = 0, padd4_4 = 0, padd4_5 = 0, padd4_6 = 0, padd4_7 = 0, padd4_8 = 0;
	static long clng4 = 0;
	static long padd5_1 = 0, padd5_2 = 0, padd5_3 = 0, padd5_4 = 0, padd5_5 = 0, padd5_6 = 0, padd5_7 = 0, padd5_8 = 0;
	static long clng5 = 0;
	static long padd6_1 = 0, padd6_2 = 0, padd6_3 = 0, padd6_4 = 0, padd6_5 = 0, padd6_6 = 0, padd6_7 = 0, padd6_8 = 0;
	static long clng6 = 0;
	static long padd7_1 = 0, padd7_2 = 0, padd7_3 = 0, padd7_4 = 0, padd7_5 = 0, padd7_6 = 0, padd7_7 = 0, padd7_8 = 0;
	static long clng7 = 0;
	
    static final int COUNT_TO = 1_000_000_000;
	static Integer INTEGER = 0;
	
	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
	
	public static long prologue() {
		counter = 0;
		var thrId = Thread.currentThread().getId();
		padd1_1 = padd1_2 = padd1_3 = padd1_4 = padd1_5 = padd1_6 = padd1_7 = padd1_8 = thrId;
		padd2_1 = padd2_2 = padd2_3 = padd2_4 = padd2_5 = padd2_6 = padd2_7 = padd2_8 = thrId;
		padd3_1 = padd3_2 = padd3_3 = padd3_4 = padd3_5 = padd3_6 = padd3_7 = padd3_8 = thrId;
		padd4_1 = padd4_2 = padd4_3 = padd4_4 = padd4_5 = padd4_6 = padd4_7 = padd4_8 = thrId;
		padd5_1 = padd5_2 = padd5_3 = padd5_4 = padd5_5 = padd5_6 = padd5_7 = padd5_8 = thrId;
		padd6_1 = padd6_2 = padd6_3 = padd6_4 = padd6_5 = padd6_6 = padd6_7 = padd6_8 = thrId;
		padd7_1 = padd7_2 = padd7_3 = padd7_4 = padd7_5 = padd7_6 = padd7_7 = padd7_8 = thrId;
		paddsb1_1 = paddsb1_2 = paddsb1_3 = paddsb1_4 = paddsb1_5 = paddsb1_6 = paddsb1_7 = paddsb1_8 = thrId;
		paddsb2_1 = paddsb2_2 = paddsb2_3 = paddsb2_4 = paddsb2_5 = paddsb2_6 = paddsb2_7 = paddsb2_8 = thrId;
		paddsb3_1 = paddsb3_2 = paddsb3_3 = paddsb3_4 = paddsb3_5 = paddsb3_6 = paddsb3_7 = paddsb3_8 = thrId;
		paddsb4_1 = paddsb4_2 = paddsb4_3 = paddsb4_4 = paddsb4_5 = paddsb4_6 = paddsb4_7 = paddsb4_8 = thrId;
		paddsb5_1 = paddsb5_2 = paddsb5_3 = paddsb5_4 = paddsb5_5 = paddsb5_6 = paddsb5_7 = paddsb5_8 = thrId;
		paddsb6_1 = paddsb6_2 = paddsb6_3 = paddsb6_4 = paddsb6_5 = paddsb6_6 = paddsb6_7 = paddsb6_8 = thrId;
		paddsb7_1 = paddsb7_2 = paddsb7_3 = paddsb7_4 = paddsb7_5 = paddsb7_6 = paddsb7_7 = paddsb7_8 = thrId;
		paddsb8_1 = paddsb8_2 = paddsb8_3 = paddsb8_4 = paddsb8_5 = paddsb8_6 = paddsb8_7 = thrId;
		
		flushStoreBuffer1 = flushStoreBuffer2 = 0;
		flushStoreBuffer3 = flushStoreBuffer4 = 0;
		flushStoreBuffer5 = flushStoreBuffer6 = 0;
		flushStoreBuffer7 = flushStoreBuffer8 = 0;
		
		lng0 = 0; lng1 = 0;	lng2 = 0; lng3 = 0; lng3 = 0; lng4 = 0; lng5 = 0; lng6 = 0;	lng7 = 0;
		clng0 = 0; clng1 = 0; clng2 = 0; clng3 = 0; clng3 = 0; clng4 = 0; clng5 = 0; clng6 = 0;	clng7 = 0;
		return padd1_1 + padd2_2 + padd3_3 + padd4_4 + padd5_5 + padd6_6 + padd7_7 + padd7_8;
	}

	public static boolean epilogue() {
		counter = 0;
		lng0 = 0; lng1 = 0;	lng2 = 0; lng3 = 0; lng3 = 0; lng4 = 0; lng5 = 0; lng6 = 0;	lng7 = 0;
		clng0 = 0; clng1 = 0; clng2 = 0; clng3 = 0; clng3 = 0; clng4 = 0; clng5 = 0; clng6 = 0;	clng7 = 0;
		var thrId = Thread.currentThread().getId();		
		if (padd1_1 != thrId || padd2_2 != thrId || padd3_3 != thrId || padd4_4 != thrId || padd5_5 != thrId
				|| padd6_6 != thrId || padd7_7 != thrId || padd7_8 != thrId || paddsb1_1 != thrId || paddsb2_2 != thrId
				|| paddsb3_3 != thrId || paddsb4_4 != thrId || paddsb5_5 != thrId || paddsb6_6 != thrId
				|| paddsb7_7 != thrId) {
			throw new RuntimeException("epilogue failed!");
		}
		return true;
	}
	
	
//	@Benchmark
//	public static void countWith1ThreadInteger(Blackhole blackhole) {
//		INTEGER = 0;
//		int end = COUNT_TO;
//		Thread t = new Thread(() -> {
//			for (int i = 0; i < end; i++) {
//				blackhole.consume(INTEGER++);
//			}
//		});
//		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//		if (INTEGER != COUNT_TO)
//			throw new RuntimeException("countWith1ThreadInteger failed!");
//	}
	
//	@Benchmark
//	public static void countWith1ThreadIntegerNoEscape(Blackhole blackhole) {
//		INTEGER = 0;
//		int end = COUNT_TO;
//		Thread t = new Thread(() -> {
//			Integer int_ = 0;
//			for (int i = 0; i < end; i++) {
//				blackhole.consume(int_++);
//			}
//			INTEGER = int_;
//		});
//		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//		if (INTEGER != COUNT_TO)
//			throw new RuntimeException("countWith1ThreadIntegerNoEscape failed!");
//	}
	
	@Benchmark
	public static void countWith1ThreadCounterNonVolatile(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO;
		Thread t = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(counter++);
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (counter != COUNT_TO)
			throw new RuntimeException("countWith1ThreadCounterNonVolatile failed!");
		epilogue();
	}
	
	@Benchmark
	public static void countWith1Thread(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO;
		Thread t = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng0++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (lng0 != COUNT_TO || flushStoreBuffer1 != end / 8)
			throw new RuntimeException("countWith1Thread failed!");
		epilogue();
	}
	
	@Benchmark
	public static void countWith2Threads(Blackhole blackhole) {		
		prologue();
		int end = COUNT_TO / 2;
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng2++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng3++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		t2.start();
		t1.start();
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (lng2 + lng3 != COUNT_TO || flushStoreBuffer1 + flushStoreBuffer2 > end )
			throw new RuntimeException("countWith2Threads failed!");
		epilogue();
	}

	@Benchmark
	public static void countWith4Threads(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO / 4;
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng1++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng2++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng3++);
				if ((i & 7) == 0) flushStoreBuffer3++; // flush every 8th iteration
			}
		});
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng4++);
				if ((i & 7) == 0) flushStoreBuffer4++; // flush every 8th iteration
			}
		});
		t4.start();
		t3.start();
		t2.start();
		t1.start();
		try {
			t4.join();
			t3.join();
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (lng1 + lng2 + lng3 + lng4 != COUNT_TO)
			throw new RuntimeException("countWith4Thread failed! : " + lng1 + lng2 + lng3 + lng4);
		epilogue();
	}
	
	@Benchmark
	public static void countWith8Threads(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO / 8;
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng0++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng1++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng2++);
				if ((i & 7) == 0) flushStoreBuffer3++; // flush every 8th iteration
			}
		});
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng3++);
				if ((i & 7) == 0) flushStoreBuffer4++; // flush every 8th iteration
			}
		});
		Thread t5 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng4++);
				if ((i & 7) == 0) flushStoreBuffer5++; // flush every 8th iteration
			}
		});
		Thread t6 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng5++);
				if ((i & 7) == 0) flushStoreBuffer6++; // flush every 8th iteration
			}
		});
		Thread t7 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng6++);
				if ((i & 7) == 0) flushStoreBuffer7++; // flush every 8th iteration
			}
		});
		Thread t8 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng7++);
				if ((i & 7) == 0) flushStoreBuffer8++; // flush every 8th iteration
			}
		});
		t8.start();
		t7.start();
		t6.start();
		t5.start();
		t4.start();
		t3.start();
		t2.start();
		t1.start();
		try {
			t8.join();
			t7.join();
			t6.join();
			t5.join();
			t4.join();
			t3.join();
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		long sum = lng0 + lng1 + lng2+ lng3 + lng4 + lng5 + lng6 + lng7;
		if (sum != COUNT_TO)
			throw new RuntimeException("countWith8Threads failed! : " + sum);
		epilogue();
	}
	
	@Benchmark
	public static long countWith2ThreadsDifferentCacheLine(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO / 2;
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(lng7++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng7++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		t2.start();
		t1.start();
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (lng7 + clng7 != COUNT_TO 
				|| flushStoreBuffer1 + flushStoreBuffer2 > end )
			throw new RuntimeException("countWith4ThreadsDifferentCacheLine failed!");
		epilogue();
		
		return padd1_1 + padd2_2 + padd3_3 + padd4_4 +
				padd5_5 + padd6_6 + padd7_7;				
	}
	
	@Benchmark
	public static long countWith4ThreadsDifferentCacheLine(Blackhole blackhole) {
		prologue();
		int end = COUNT_TO / 4;
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng0++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng1++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng2++);
				if ((i & 7) == 0) flushStoreBuffer3++; // flush every 8th iteration
			}
		});
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng3++);
				if ((i & 7) == 0) flushStoreBuffer4++; // flush every 8th iteration
			}
		});
		t4.start();
		t3.start();
		t2.start();
		t1.start();
		try {
			t4.join();
			t3.join();
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (clng0 + clng1 + clng2 + clng3 != COUNT_TO)
			throw new RuntimeException("countWith4ThreadsDifferentCacheLine failed!");
		
		epilogue();
		
		return padd1_1 + padd2_2 + padd3_3 + padd4_4 +
				padd5_5 + padd6_6 + padd7_7;
	}
	
	@Benchmark
	public static long countWith8ThreadsDifferentCacheLine(Blackhole blackhole) {
		prologue();	
		
		int end = COUNT_TO / 8;
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng0++);
				if ((i & 7) == 0) flushStoreBuffer1++; // flush every 8th iteration
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng1++);
				if ((i & 7) == 0) flushStoreBuffer2++; // flush every 8th iteration
			}
		});
		
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng2++);
				if ((i & 7) == 0) flushStoreBuffer3++; // flush every 8th iteration
			}
		});
		
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng3++);
				if ((i & 7) == 0) flushStoreBuffer4++; // flush every 8th iteration
			}
		});
		
		Thread t5 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng4++);
				if ((i & 7) == 0) flushStoreBuffer5++; // flush every 8th iteration
			}
		});
		
		Thread t6 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng5++);
				if ((i & 7) == 0) flushStoreBuffer6++; // flush every 8th iteration
			}
		});
		
		Thread t7 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng6++);
				if ((i & 7) == 0) flushStoreBuffer7++; // flush every 8th iteration
			}
		});
		
		Thread t8 = new Thread(() -> {
			for (int i = 0; i < end; i++) {
				blackhole.consume(clng7++);
				if ((i & 7) == 0) flushStoreBuffer8++; // flush every 8th iteration
			}
		});
		
		t8.start();
		t7.start();
		t6.start();
		t5.start();
		t4.start();
		t3.start();
		t2.start();
		t1.start();
		
		try {
			t8.join();
			t7.join();
			t6.join();
			t5.join();
			t4.join();
			t3.join();
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		long sum = clng0 + clng1 + clng2 + clng3 + clng4 + clng5 + clng6 + clng7;
		if (sum != COUNT_TO)
			throw new RuntimeException("countWith8ThreadsDifferentCacheLine failed! : " + sum);
		
		epilogue();
		
		return padd1_1 + padd2_2 + padd3_3 + padd4_4 + padd5_5 + padd6_6 + padd7_7;
	}
}

