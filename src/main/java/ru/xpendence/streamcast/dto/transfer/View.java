package ru.xpendence.streamcast.dto.transfer;

/**
 * @author Vyacheslav Chernyshov, chernyshov@bakapp.ru
 * @date 26.12.17
 */
public interface View {

    interface New {

        interface Log {

        }

        interface Entity {

        }

    }

    interface Exists {

        interface Log {

        }

        interface Entity {

        }

        interface Stats {

        }
    }

    interface DayBorders {

    }

    interface Stats {

    }

    interface Calculate {

    }

    interface DoNotShow {

    }
}
