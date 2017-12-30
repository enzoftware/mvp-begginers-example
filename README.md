# WTF is MVP ?

---

<div align="center">
<img src="https://uploads.toptal.io/blog/image/92723/toptal-blog-image-1467297442604-1e81ce426afbf5ff929e8586b2e87539.jpg"/>
</div>

---

> Sometimes android devs give Activity responsibility for everything around them. Activity (or Fragment, or other view) downloads data, sends to save, presents them, responds to user interactions, edits data, manages all child views . . . and often much more. It’s too much for such unstable objects like Activities or Fragments - Tomasz Czura

#### A very good idea is to isolate responsibilities from views and make them as stupid as possible. Views (Activities, Fragments, custom views, or whatever presents data on screen) should be only responsible for managing their subviews. Views should have presenters, who will communicate with model, and tell them what they should do. This, in short, is the Model-View-Presenter pattern

## What does each layer knows ?
- View knows “I’m Activity, I have two EditTexts and one Button. When somebody clicks the button, I should tell it to my presenter, and pass him EditTexts’ values. And that’s all, I can sleep until next click or presenter tells me what to do.”

- Presenter knows that somewhere is a View, and he knows what operations this View can perform. He also knows that when he receives two strings, he should create User from these two strings and send data to model to save, and if save is successful, tell the view ‘Show success info’.

- Model just knows where data is, where they should be saved, and what operations should be performed on the data.

## Why MVP ?
Applications written in MVP are easy to test, maintain, and reuse. A pure presenter should know nothing about the Android platform. It should be pure Java (or Kotlin, in our case) class. Thanks to this we can reuse our presenter in other projects. We can also easily write unit tests, testing separately Model, View and Presenter.

## Reference :
- [Introduction to Kotlin: Android Programming For Humans](https://www.toptal.com/software/kotlin-android-language)
