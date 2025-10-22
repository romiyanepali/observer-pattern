package be.ucll.craftmanship.DDDDemo.library.shared.utils;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DomainEventPublisher implements EventPublisher {
    private final Set<Observer> observers = new HashSet<>();

    @Override
    public void publish(Event event) {
        for (var observer : this.observers) {
            observer.onEvent(event);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }
}
