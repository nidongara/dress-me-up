package com.docusign.interfaces;

import com.docusign.objects.Command;

import java.util.List;
import java.util.Map;

/**
 * Created by nihardongara on 2/23/17.
 */
public interface CommandsManager {
    List<Command> getCommands();
    Map<Integer, Command> getCommandMap();
}
