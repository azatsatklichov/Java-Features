package tasks.algorithmic.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.TreeSet;

public class FindByMax {
	/**
	 * Given a file (suppose quite big file) with domain names and count of its
	 * accessibility, mixed order. Task is read first top 10 and list them by max
	 * accessibility.
	 * 
	 * @throws URISyntaxException
	 * 
	 */
	public static void main(String[] args) throws URISyntaxException {
		// InputStream inputStream = FindByMax.class.getResourceAsStream("domains.txt");
		int N = 10; // first top 10

		Comparator<Domain> dc = (d1, d2) -> {
			if (d2.getAccessCount() > d1.getAccessCount()) {
				return 1;
			} else {
				return -1;
			}
		};

		TreeSet<Domain> domainSet = new TreeSet<Domain>(dc); // Set
		Path path = Paths.get(FindByMax.class.getClassLoader().getResource("domains.txt").toURI());
		int count = 0;
		try (BufferedReader reader = Files.newBufferedReader(path)) { // for big files
			String line;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				line = line.strip(); /// trim();
				if (!"".equals(line)) {
					String[] split = line.split(";");
					// if (count < N) {
					domainSet.add(new Domain(Long.valueOf(split[0]), split[1], Long.valueOf(split[2])));
					/*
					 * } else {
					 *//**
						 * rates.stream().sorted((o1, o2) ->
						 * o2.getStandardRate().compareTo(o1.getStandardRate()))
						 * .limit(count).map(Rate::getName).collect(Collectors.toList());
						 *//*
							 * domainSet.add(new Domain(Long.valueOf(split[0]), split[1],
							 * Long.valueOf(split[2]))); Domain smallest = domainSet.last();
							 * System.out.println(smallest); boolean removed = domainSet.remove(smallest);
							 * System.out.println(removed); }
							 */
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		domainSet.stream().limit(10).forEach(System.out::println);

	}
}

class Domain implements Comparable<Domain> {
	private Long rank;
	private String domainName;
	private Long accessCount;

	public Domain(Long rank, String domainName, Long accessCount) {
		this.rank = rank;
		this.domainName = domainName;
		this.accessCount = accessCount;
	}

	public String getDomainName() {
		return domainName;
	}

	public Long getAccessCount() {
		return accessCount;
	}

	public Long getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "Domain [" + domainName + ", accessCount = " + accessCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		Domain that = (Domain) obj;
		if (this.getAccessCount().equals(that.getAccessCount()) && this.getRank().equals(that.getRank())
				&& this.getDomainName().equals(that.getDomainName())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return (int) (this.getAccessCount() * 17);
	}

	@Override
	public int compareTo(Domain o) {
		return this.accessCount.compareTo((long) o.compareTo(o));
	}
}

class DomainComparator implements Comparator<Domain> {

	@Override
	public int compare(Domain d1, Domain d2) {
		if (d2.getAccessCount() > d1.getAccessCount()) {
			return 1;
		} else {
			return -1;
		}
	}
}