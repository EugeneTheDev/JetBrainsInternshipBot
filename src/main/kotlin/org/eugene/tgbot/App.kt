package org.eugene.tgbot

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi


fun main(args: Array<String>) {
    ApiContextInitializer.init()
    TelegramBotsApi().registerBot(Bot())
}