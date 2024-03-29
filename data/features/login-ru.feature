# language: ru
@LoginProfile
Функционал: Тестируем страницу авторизации
  сайта automationpractice.com с водом
  заведомо неверных данных и проверяем
  отображаемые сообщения об ошибках

  Структура сценария: Неудачная авторизация
    Пусть Я нахожусь на домашней странице
    Затем Я нажимаю ссылку signIn
    Когда Ввожу логин '<логин>'
    Также Ввожу пароль '<пароль>'
    И нажимаю отправить
    Тогда должен увидеть сообщение об ошибке '<сообщение>'

    Примеры:
      | логин                    | пароль        | сообщение                   |
      | yavoric@rambler.ru.com   |123            |Invalid password.            |
      | 123                      |123qwerty      |Invalid email address.       |