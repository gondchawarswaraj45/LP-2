import random
import datetime

print("===================================")
print("        CUSTOMER CHATBOT")
print("===================================")

name = input("Enter your name: ")

print("\nBot: Hello", name)
print("Bot: Type 'help' to see commands")
print("Bot: Type 'exit' to stop\n")

while True:

    msg = input(name + ": ").lower()

    if msg == "exit":

        print("Bot: Thank you for chatting")
        print("Bot: Have a nice day")
        break

    elif msg == "help":

        print("\nAvailable Commands:")
        print("1. hi / hello")
        print("2. how are you")
        print("3. your name")
        print("4. time")
        print("5. date")
        print("6. weather")
        print("7. services")
        print("8. price")
        print("9. contact")
        print("10. thanks")
        print("11. bye")
        print("12. exit\n")

    elif "hi" in msg or "hello" in msg:

        responses = [
            "Hello " + name,
            "Hi there",
            "Welcome",
            "Nice to meet you"
        ]

        print("Bot:", random.choice(responses))

    elif "how are you" in msg:

        responses = [
            "I am fine",
            "Doing great",
            "I am working perfectly",
            "Thanks for asking"
        ]

        print("Bot:", random.choice(responses))

    elif "your name" in msg:

        print("Bot: My name is Customer Support Bot")

    elif "time" in msg:

        current_time = datetime.datetime.now().strftime("%H:%M:%S")

        print("Bot: Current time is", current_time)

    elif "date" in msg:

        current_date = datetime.datetime.now().strftime("%d-%m-%Y")

        print("Bot: Today's date is", current_date)

    elif "weather" in msg:

        responses = [
            "Today's weather is pleasant",
            "It may rain today",
            "Weather is sunny today"
        ]

        print("Bot:", random.choice(responses))

    elif "services" in msg:

        print("\nBot: Our Services")
        print("1. Product Information")
        print("2. Order Tracking")
        print("3. Customer Support")
        print("4. Technical Assistance\n")

    elif "price" in msg:

        print("Bot: Prices depend on the selected product")

    elif "contact" in msg:

        print("Bot: Contact us at support@gmail.com")

    elif "thanks" in msg or "thank you" in msg:

        responses = [
            "Welcome",
            "Happy to help",
            "Thank you"
        ]

        print("Bot:", random.choice(responses))

    elif "bye" in msg:

        print("Bot: Goodbye")
        print("Bot: Visit again")
        break

    else:

        print("Bot: Sorry, I don't understand")
        print("Bot: Type 'help' to see available commands\n")