package org.eugene.tgbot
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.telegram.abilitybots.api.bot.AbilityBot
import org.telegram.abilitybots.api.objects.Reply
import java.lang.Integer.parseInt
import java.util.function.Predicate

class Bot(private val creatorId: Int = 479353967): AbilityBot(
        "788863810:AAFQqAQfTuh-o53WKOx-Nl0bNF1dvMg-a2c",
        "jet_brains_int_bot") {

    override fun creatorId(): Int {
        return creatorId
    }

    fun reply(): Reply{
        return Reply.of({
            GlobalScope.launch {
                try {
                    val list = it.message.text.split(":")
                    val seconds = when {
                        list.size == 3 -> parseInt(list[0]) * 60 * 60 + parseInt(list[1]) * 60 + parseInt(list[2])
                        list.size == 2 -> parseInt(list[0]) * 60 * 60 + parseInt(list[1]) * 60
                        else -> parseInt(it.message.text)
                    }
                    delay(seconds * 1000L)
                    silent.send("I am replying you after $seconds seconds of delay: hi!", it.message.chatId)
                } catch (e: NumberFormatException) {
                    silent.send("Please, send me a number of seconds, hh:mm or hh:mm:ss", it.message.chatId)
                }
            }

        }, arrayOf(Predicate{it.hasMessage()}))
    }


}