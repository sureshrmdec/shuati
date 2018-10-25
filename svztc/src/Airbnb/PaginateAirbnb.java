package Airbnb;

import java.util.*;

/**
 Airbnb Online Assessment Paginate List

 5
 13
 1,28,310.6,SF
 4,5,204.1,SF
 20,7,203.2,Oakland
 6,8,202.2,SF
 6,10,199.1,SF
 1,16,190.4,SF
 6,29,185.2,SF
 7,20,180.1,SF
 6,21,162.1,SF
 2,18,161.2,SF
 2,30,149.1,SF
 3,76,146.2,SF
 2,14,141.1,San Jose


 Here is a sample input. It’s a list generated by user search.
 (1,28,100.3,Paris) corresponds to (Host ID, List ID, Points, City).

 5 in the first row tells each page at most keeps 5 records.
 13 in the second row is the number of records in the list.

 Please paginate the list for Airbnb by requirement:
 1. When possible, two records with same host ID shouldn’t be in a page.
 2. But if no more records with non-repetitive host ID can be found, fill up the page with the given input order (ordered by Points).

 Expected output:
 1,28,310.6,SF
 4,5,204.1,SF
 20,7,203.2,Oakland
 6,8,202.2,SF
 7,20,180.1,SF

 6,10,199.1,SF
 1,16,190.4,SF
 2,18,161.2,SF
 3,76,146.2,SF
 6,29,185.2,SF  -- 6 repeats since no more unique host ID available

 6,21,162.1,SF
 2,30,149.1,SF
 2,14,141.1,San Jose

 */

public class PaginateAirbnb {

    int recordsPerPage, numberOfRecords;

    public static void main(String args[]) {
        PaginateAirbnb t = new PaginateAirbnb();
        t.paginate();
    }

    public void paginate() {
        LinkedList<String> records = new LinkedList<>();
        getInput(records);
        System.out.println(records);
        Set<Integer> hostsInCurrentPage = new HashSet<>();
        int n = recordsPerPage; // records count in current page
        while(!records.isEmpty()) {
            int i = 0;
            while(!records.isEmpty() && n > 0 && i < records.size()) {
                int host = getHostID(records.get(i));
                if(hostsInCurrentPage.contains(host)) {
                    i++;
                } else {
                    hostsInCurrentPage.add(host);
                    System.out.println(records.get(i));
                    records.remove(i);
                    n--;
                }
            }
            if(i == records.size()) break;
            hostsInCurrentPage = new HashSet<>();
            n = recordsPerPage;
            i = 0;
            System.out.println();
        }
        while (!records.isEmpty()) {
            while(!records.isEmpty() && n > 0) {
                System.out.println(records.get(0));
                records.remove(0);
                n--;
            }
            System.out.println();
            n = recordsPerPage;
        }
    }

    private int getHostID(String s) {
        return Integer.parseInt(s.substring(0, s.indexOf(',')));
    }

    private void getInput(LinkedList<String> records) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext()) {
            recordsPerPage = sc.nextInt();
        } else {
            throw new InputMismatchException();
        }
        if(sc.hasNext()) {
            numberOfRecords = sc.nextInt();
        } else {
            throw new InputMismatchException();
        }

        while(numberOfRecords > 0) {
            if(sc.hasNext()) {
                records.add(sc.next());
            } else {
                throw new InputMismatchException();
            }
            numberOfRecords--;
        }
    }


}
