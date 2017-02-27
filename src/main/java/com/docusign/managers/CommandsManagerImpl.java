package com.docusign.managers;

import com.docusign.enums.Temperature;
import com.docusign.interfaces.CommandsManager;
import com.docusign.objects.Command;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Repo that stores all the commands after.
 * Can use the test input or can get the commands from a data source.
 */
@Component
public class CommandsManagerImpl implements CommandsManager{
    private List<Command> commands;

    public CommandsManagerImpl() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command(1,"Put on footwear", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "sandals"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "boots"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(2,"Put on headwear", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "sun visor"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "hat"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(3,"Put on socks", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "fail"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "socks"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(4,"Put on shirt", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "t-shirt"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "shirt"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(5,"Put on jacket", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "fail"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "jacket"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(6,"Put on pants", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "shorts"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "pants"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(7,"Leave house", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "leaving house"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "leaving house"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        commands.add(new Command(8,"Take off pajamas", Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Temperature.HOT, "Removing PJs"),
                new AbstractMap.SimpleEntry<>(Temperature.COLD, "Removing PJs"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())))));
        this.commands = commands;
    }

    /**
     * @return List of all commands
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     *
     * @return Map of all all commands
     */
    public Map<Integer, Command> getCommandMap() {
        if(commands !=null && commands.size() > 0){
            return commands.stream().collect(Collectors.toMap(Command::getNumber, command -> command));
        }
        return new HashMap<>();
    }
}
