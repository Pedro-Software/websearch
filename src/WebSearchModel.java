import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WebSearchModel {
    private final File sourceFile;
    private final List<ObserverFilter> observers = new ArrayList<>();

    public interface QueryObserver {
        void onQuery(String query);
    }

    private static class ObserverFilter {
        QueryObserver observer;
        QueryFilter filter;

        ObserverFilter(QueryObserver observer, QueryFilter filter) {
            this.observer = observer;
            this.filter = filter;
        }
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                notifyAllObservers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver observer, QueryFilter filter) {
        observers.add(new ObserverFilter(observer, filter));
    }

    private void notifyAllObservers(String query) {
        for (ObserverFilter item : observers) {
            if (item.filter.matches(query)) {
                item.observer.onQuery(query);
            }
        }
    }
}
