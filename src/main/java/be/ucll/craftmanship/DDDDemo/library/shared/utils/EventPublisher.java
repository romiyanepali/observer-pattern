package be.ucll.craftmanship.DDDDemo.library.shared.utils;

public interface EventPublisher {
    void publish(Event event);
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}
