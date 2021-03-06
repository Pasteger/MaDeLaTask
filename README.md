# drubin



## Начало работы

Чтобы вам было проще начать работу с GitLab, вот список рекомендуемых следующих шагов.

Уже профессионал? Просто отредактируйте это README.md и сделай это по-своему. Хотите сделать это проще? [Используйте шаблон внизу](#Редактирование этого README)!

## Добавьте свои файлы

- [ ] [Создать](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file ) или [загрузить](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file ) файлы
- [ ] [Добавление файлов с помощью командной строки](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line ) или запустите существующий репозиторий Git с помощью следующей команды:

```
cd existing_repo
git remote add origin https://gitlab.com/goryacms/drubin.git
git branch -M main
git push -uf origin main
```

## Интеграция с вашими инструментами

- [ ] [Настройка интеграции проектов](https://gitlab.com/goryacms/drubin/-/settings/integrations )

## Сотрудничайте со своей командой

- [ ] [Пригласить членов команды и сотрудников](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Создать новый запрос на слияние](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html )
- [ ] [Автоматическое закрытие проблем при слиянии requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Включить утверждения запросов на слияние](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Автоматическое слияние при успешном завершении конвейера](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html )

## Тестирование и развертывание

Используйте встроенную непрерывную интеграцию в GitLab.

- [ ] [Начало работы с GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html )
- [ ] [Проанализируйте свой код на наличие известных уязвимостей с помощью статического тестирования безопасности приложений (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Развертывание в Kubernetes, Amazon EC2 или Amazon ECS с использованием автоматического развертывания](https://docs.gitlab.com/ee/topics/autodevops/requirements.html )
- [ ] [Используйте развертывания на основе извлечения для улучшения управления Kubernetes](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Настройка защищенных сред](https://docs.gitlab.com/ee/ci/environments/protected_environments.html )

***

# Редактирование этого README

Когда вы будете готовы сделать этот README своим, просто отредактируйте этот файл и используйте удобный шаблон ниже (или не стесняйтесь структурировать его так, как вы хотите - это только отправная точка!).  Спасибо вам за [makeareadme.com](https://www.makeareadme.com/) для этого шаблона.

## Предложения для хорошего README
Каждый проект индивидуален, поэтому подумайте, какой из этих разделов применим к вашему. Разделы, используемые в шаблоне, являются рекомендациями для большинства проектов с открытым исходным кодом. Также имейте в виду, что, хотя README может быть слишком длинным и подробным, слишком длинный лучше, чем слишком короткий. Если вы считаете, что ваш README слишком длинный, рассмотрите возможность использования другой формы документации, а не вырезания информации.

## Имя
Выберите понятное название для вашего проекта.

## Описание
Дайте людям знать, что конкретно может сделать ваш проект. Укажите контекст и добавьте ссылку на любую ссылку, с которой посетители могут быть незнакомы. Здесь также можно добавить список функций или подраздел "Справочная информация". Если у вашего проекта есть альтернативы, это хорошее место для перечисления отличительных факторов.

## Значки
На некоторых READMEs вы можете увидеть небольшие изображения, которые передают метаданные, например, проходят ли все тесты для проекта. Вы можете использовать щиты, чтобы добавить их в свой README. Во многих сервисах также есть инструкции по добавлению бейджа.

## Визуальные эффекты
В зависимости от того, что вы делаете, может быть хорошей идеей включить скриншоты или даже видео (вы часто будете видеть GIF-файлы, а не реальные видео). Такие инструменты, как ttygif, могут помочь, но ознакомьтесь с Asciinema для более сложного метода.

## Установка
В рамках конкретной экосистемы может существовать распространенный способ установки вещей, например, с помощью Yarn, NuGet или Homebrew. Однако учтите возможность того, что тот, кто читает ваш README, является новичком и хотел бы получить больше рекомендаций. Перечисление конкретных шагов помогает устранить двусмысленность и как можно быстрее привлечь людей к использованию вашего проекта. Если он запускается только в определенном контексте, например, в конкретной версии языка программирования или операционной системе, или имеет зависимости, которые необходимо устанавливать вручную, также добавьте подраздел Требований.

## Использование
Широко используйте примеры и, если сможете, покажите ожидаемый результат. Полезно иметь встроенный наименьший пример использования, который вы можете продемонстрировать, предоставляя ссылки на более сложные примеры, если они слишком длинные, чтобы разумно включить их в README.

## Поддержка
Скажите людям, куда они могут обратиться за помощью. Это может быть любая комбинация отслеживания проблем, комнаты чата, адреса электронной почты и т.д.

## Дорожная карта
Если у вас есть идеи для будущих релизов, было бы неплохо перечислить их в README.

## Участие
Укажите, открыты ли вы для пожертвований и каковы ваши требования для их принятия.

Для людей, которые хотят внести изменения в ваш проект, полезно иметь некоторую документацию о том, как начать работу. Возможно, есть сценарий, который они должны запустить, или какие-то переменные среды, которые им нужно установить. Сделайте эти шаги явными. Эти инструкции также могут быть полезны вам в будущем.

Вы также можете документировать команды для обработки кода или запуска тестов. Эти шаги помогают обеспечить высокое качество кода и снизить вероятность того, что изменения непреднамеренно что-то нарушат. Наличие инструкций по запуску тестов особенно полезно, если требуется внешняя настройка, например, запуск сервера Selenium для тестирования в браузере.

## Авторы и благодарность
Выразите свою признательность тем, кто внес свой вклад в проект.

## Лицензия
Для проектов с открытым исходным кодом укажите, как он лицензируется.

## Статус проекта
Если у вас закончились силы или время для вашего проекта, поместите заметку в верхней части README о том, что разработка замедлилась или полностью остановилась. Кто-то может решить разветвить ваш проект или добровольно выступить в качестве сопровождающего или владельца, что позволит вашему проекту продолжать развиваться. Вы также можете сделать явный запрос для сопровождающих.