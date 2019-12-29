package tasks.algorithmic.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Program: Write a program to find two lines with max characters in descending
 * order.
 * 
 * Description:
 * 
 * Write a program to read a multiple line text file and write the 'N' longest
 * lines to the output console, where the file to be read is specified as
 * command line aruguments. The program should read an input file. The first
 * line should contain the value of the number 'N' followed by multiple lines.
 * 'N' should be a valid positive integer.
 * 
 * @author Azat
 * 
 */
public class MaxCharacters_Desc {
	public static void main(String[] args) {

		BufferedReader br = null;
		String filePath = "C:\\workspace-java essentials\\_MainJavaCorner\\ahoj2"; // args[0];
		int topList = 0;
		Set<Entries> liSet = new TreeSet<Entries>(new MyComp());
		try {
			br = new BufferedReader(new FileReader(new File(filePath)));
			String line = br.readLine();
			topList = Integer.parseInt(line.trim());
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!"".equals(line)) {
					liSet.add(new Entries(line.length(), line));
				}
			}
			int count = 0;
			for (Entries ent : liSet) {
				System.out.println(ent.line);
				if (++count == topList) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class Entries {
		Integer length;
		String line;

		public Entries(Integer l, String line) {
			length = l;
			this.line = line;
		}
	}

	public static class MyComp implements Comparator<Entries> {

		@Override
		public int compare(Entries e1, Entries e2) {
			if (e2.length > e1.length) {
				return 1;
			} else {
				return -1;
			}
		}

	}
}


@Test
    public void whenReadBigFile_MGM() throws IOException {
        List<Mgm> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
            String line;
            while ((line = br.readLine()) != null) {
                addMgm(list, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, list.size());
    }

    @Test
    public void whenReadByScanner_MGM() throws IOException {
        List<Mgm> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file3))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                addMgm(list, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, list.size());
    }

    private void addMgm(List<Mgm> list, String line) {
        System.out.println(line);
        String[] split = line.toString().split(";");
        Mgm mgm = new Mgm(split[0], new Integer(split[1]));
        list.add(mgm);
    }
	
	
	
class Mgm {
    private String domain;
    private int accessCount;

    public Mgm(String domain, int accessCount) {
        this.domain = domain;
        this.accessCount = accessCount;
    }

    public String getDomain() {
        return domain;
    }

    public int getAccessCount() {
        return accessCount;
    }

    @Override
    public String toString() {
        return "domain: " + domain + "; accessCount:" + accessCount;
    }

}
