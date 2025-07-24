class TodoList {
    def tasks = []

    def addTask(taskName) {
        tasks.add(taskName)
        println "تمت إضافة: $taskName"
    }

    def showTasks() {
        if (tasks.empty) {
            println "لا توجد مهام حالياً"
            return
        }

        println "\nقائمة المهام:"
        tasks.eachWithIndex { task, index ->
            println "${index + 1}. $task"
        }
    }

    def removeTask(taskNumber) {
        if (taskNumber > tasks.size()) {
            println "رقم المهمة غير صحيح!"
            return
        }

        def removed = tasks.remove(taskNumber - 1)
        println "تم حذف: $removed"
    }
}

def todo = new TodoList()

println "=== نظام إدارة المهام البسيط ==="
println "الأوامر:"
println "1. add [المهمة] - لإضافة مهمة"
println "2. list - لعرض المهام"
println "3. remove [الرقم] - لحذف مهمة"
println "4. exit - للخروج"

while (true) {
    print "\nأدخل الأمر: "
    def input = System.console().readLine().trim()

    if (input.startsWith("add ")) {
        def task = input.substring(4)
        todo.addTask(task)
    } else if (input == "list") {
        todo.showTasks()
    } else if (input.startsWith("remove ")) {
        def num = input.substring(7)
        if (num.isNumber()) {
            todo.removeTask(num.toInteger())
        } else {
            println "يجب إدخال رقم المهمة"
        }
    } else if (input == "exit") {
        println "مع السلامة!"
        break
    } else {
        println "أمر غير معروف!"
    }
}

