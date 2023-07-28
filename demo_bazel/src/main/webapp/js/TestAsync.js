function sleep(seconds)
{
  let e = new Date().getTime() + (seconds * 1000);
  while (new Date().getTime() <= e) {}
}

function Task1() {
  console.log("Task 1 invoked");
  sleep(2);
  console.log("Task 1 done");
}
function Task2() {
  console.log("Task 2 invoked");
  sleep(2);
  console.log("Task 2 done");
}
function Task3() {
  console.log("Task 3 invoked");
  sleep(2);
  console.log("Task 3 done");
}

function yieldToMain () {
  return new Promise(resolve => {
    setTimeout(resolve, 0);
  });
}

async function MainThread() {
  const tasks = [
      Task1(),
      Task2(),
      Task3()
  ]

  while (tasks.length > 0) {
    const task = tasks.shift();

    task();

    await yieldToMain();
  }

}

MainThread();