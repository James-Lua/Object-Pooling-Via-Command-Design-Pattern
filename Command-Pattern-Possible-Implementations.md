This diagram is an extended version of the true diagram, only with various commands added to visualize the use of this pattern.
```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute()
        +undo()
        +reset()
    }

    class MoveCommand {
        -Player player
        -int fromX, fromY, toX, toY
        -boolean executed
        +initialize(Player, int, int)
        +execute()
        +undo()
        +reset()
    }

    class AttackCommand {
        -Enemy target
        -int originalHealth
        -int damage
        +initialize(Player, Enemy, int)
        +execute()
        +undo()
        +reset()
    }

    class UseItemCommand {
        -Item item
        -Player player
        -int previousHealth
        +initialize(Player, Item)
        +execute()
        +undo()
        +reset()
    }

    class ChangeEquipmentCommand {
        -Player player
        -EquipmentSlot slot
        -Item oldItem
        -Item newItem
        +initialize(Player, EquipmentSlot, Item)
        +execute()
        +undo()
        +reset()
    }

    class CastSpellCommand {
        -Player player
        -Spell spell
        -int manaCost
        +initialize(Player, Spell)
        +execute()
        +undo()
        +reset()
    }

    class ToggleStealthCommand {
        -Player player
        -boolean wasStealthed
        +initialize(Player)
        +execute()
        +undo()
        +reset()
    }

    class TeleportCommand {
        -Player player
        -int fromX, fromY, toX, toY
        +initialize(Player, int, int)
        +execute()
        +undo()
        +reset()
    }

    class SaveGameCommand {
        -GameState savedState
        -GameState previousState
        +initialize(GameState)
        +execute()
        +undo()
        +reset()
    }

    Command <|-- MoveCommand
    Command <|-- AttackCommand
    Command <|-- UseItemCommand
    Command <|-- ChangeEquipmentCommand
    Command <|-- CastSpellCommand
    Command <|-- ToggleStealthCommand
    Command <|-- TeleportCommand
    Command <|-- SaveGameCommand

    AttackCommand --> Enemy : dependency
    UseItemCommand --> Item : dependency
    ChangeEquipmentCommand --> EquipmentSlot : dependency
    ChangeEquipmentCommand --> Item : dependency
    CastSpellCommand --> Spell : dependency
    SaveGameCommand --> GameState : dependency

    class Enemy {
        -int health
        +getHealth() int
        +takeDamage(int)
        +setHealth(int)
    }

    class Item {
        <<interface>>
        +use()
    }

    class EquipmentSlot {
        <<enumeration>>
        HEAD
        CHEST
        HANDS
        LEGS
    }

    class Spell {
        -int manaCost
        +getManaCost() int
        +reverseEffects()
    }

    class GameState {
        +clone() GameState
    }

    class CommandHistory {
        -Stack<Command> history
        +push(Command)
        +pop() Command
        +isEmpty() boolean
    }

    class CommandPool~C~ {
        -Stack~C~ pool
        -CommandFactory~C~ factory
        +CommandPool(int, CommandFactory~C~)
        +acquire() C
        +release(C)
    }

    class CommandManager {
        -CommandPool~MoveCommand~ moveCommandPool
        -CommandHistory commandHistory
        -Player player
        +CommandManager(Player, int)
        +executeMove(int, int)
        +undoLast()
    }

    class TurnBasedGame {
        -Player player
        -CommandManager commandManager
        +TurnBasedGame()
        +movePlayer(int, int)
        +undo()
    }

    class Player {
        -int x, y
        -int health
        -int mana
        -boolean stealthed
        +Player(int, int)
        +getX() int
        +getY() int
        +setPosition(int, int)
        +useItem(Item)
        +equipItem(EquipmentSlot, Item)
        +castSpell(Spell)
        +toggleStealth()
    }

    class GameLauncher {
        +main(String[])
    }

    CommandManager --> CommandPool~MoveCommand~ : uses
    CommandManager --> CommandHistory : uses
    CommandManager --> Player : uses
    TurnBasedGame --> CommandManager : composition
    TurnBasedGame --> Player : composition
    GameLauncher --> TurnBasedGame : dependency
    MoveCommand --> Player : dependency
    CommandPool~C~ ..> CommandFactory : inner interface

    class CommandFactory~C~ {
        <<interface>>
        +create() C
    }
    CommandPool~C~ .. CommandFactory~C~ : creates via
    ```
