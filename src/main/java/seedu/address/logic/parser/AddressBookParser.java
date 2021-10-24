package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.*;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        //Add new Commands and cases here:

        case AddEventCommand.COMMAND_WORD:
            return new AddEventCommandParser().parse(arguments);

        case RemoveEventCommand.COMMAND_WORD:
            return new RemoveEventCommandParser().parse(arguments);

        case DoneEventCommand.COMMAND_WORD:
            return new DoneEventCommandParser().parse(arguments);

        case SortEventCommand.COMMAND_WORD:
            return new SortEventCommand();

        case FilterEventCommand.COMMAND_WORD:
            return new FilterEventCommandParser().parse(arguments);

        case ListEventCommand.COMMAND_WORD:
            return new ListEventCommand();

        case AddParticipantToEventCommand.COMMAND_WORD:
            return new AddParticipantToEventParser().parse(arguments);

        case AddParticipantToEventByIndexCommand.COMMAND_WORD:
            return new AddParticipantToEventByIndexParser().parse(arguments);

        case RemoveParticipantFromEventCommand.COMMAND_WORD:
            return new RemoveParticipantFromEventParser().parse(arguments);

        case RemoveParticipantFromEventByIndexCommand.COMMAND_WORD:
            return new RemoveParticipantFromEventByIndexParser().parse(arguments);

        case AddNextOfKinCommand.COMMAND_WORD:
            return new AddNextOfKinParser().parse(arguments);

        case RemoveNextOfKinCommand.COMMAND_WORD:
            return new RemoveNextOfKinParser().parse(arguments);

        case ViewCommand.COMMAND_WORD:
            return new ViewCommandParser().parse(arguments);

        case ShowEventDetailsCommand.COMMAND_WORD:
            return new ShowEventDetailsCommandParser().parse(arguments);

        case ShowEventParticipantsCommand.COMMAND_WORD:
            return new ShowEventParticipantsCommandParser().parse(arguments);

        case FindEventCommand.COMMAND_WORD:
            return new FindEventCommandParser().parse(arguments);

        case EditEventCommand.COMMAND_WORD:
            return new EditEventCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
