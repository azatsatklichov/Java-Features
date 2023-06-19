package jvm.memory.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main3 {

	public static void main(String[] args) throws IOException {
		Person3 p = new Person3();
		final ReferenceQueue<Person3> referenceQueue = new ReferenceQueue<Person3>();
		Person3Cleaner cleaner = new Person3Cleaner();
		Person3WeakReference weakReference = new Person3WeakReference(p, cleaner, referenceQueue);

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Person3WeakReference wr = (Person3WeakReference) referenceQueue.remove();
					wr.clean();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		p = null;
		System.gc();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press any key to continue");
		br.readLine();
		executorService.shutdown();

	}
}

final class Person3 {

}

class Person3Cleaner {

	public void clean() {
		System.out.println("Cleaned");
	}
}

class Person3WeakReference extends WeakReference<Person3> {

	Person3Cleaner cleaner;

	public Person3WeakReference(Person3 referent, Person3Cleaner cleaner, ReferenceQueue<? super Person3> q) {
		super(referent, q);
		this.cleaner = cleaner;
	}

	public void clean() {
		cleaner.clean();
	}
}
