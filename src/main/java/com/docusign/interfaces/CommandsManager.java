package com.docusign.interfaces;

import com.docusign.objects.Command;

import java.util.List;
import java.util.Map;

/**
 * Interface for CommandsManager
 */
public interface CommandsManager {
    List<Command> getCommands();
    Map<Integer, Command> getCommandMap();
}
