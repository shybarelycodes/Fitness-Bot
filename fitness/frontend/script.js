// Toggle between Login and Signup
function toggleSignup(showSignup) {
    const loginForm = document.getElementById('login-form');
    const signupForm = document.getElementById('signup-form');
    const title = document.getElementById('form-title');

    if (showSignup) {
        loginForm.style.display = 'none';
        signupForm.style.display = 'block';
        title.innerText = 'Sign Up';
    } else {
        signupForm.style.display = 'none';
        loginForm.style.display = 'block';
        title.innerText = 'Login';
    }
}

// Calculate BMI based on user input (lbs + ft)
function calculateBMI() {
    const weight = parseFloat(document.getElementById("weight").value);
    const heightInput = document.getElementById("height").value.trim();
    let heightFt;
  
    if (heightInput.includes("'")) {
      const [feet, inches] = heightInput.split("'");
      heightFt = parseInt(feet) + parseInt(inches) / 12;
    } else {
      heightFt = parseFloat(heightInput);
    }
  
    if (isNaN(weight) || isNaN(heightFt)) {
      alert("Invalid input.");
      return;
    }
  
    const kg = weight * 0.453592;
    const meters = heightFt * 0.3048;
    const bmi = kg / (meters * meters);
    const bmiFixed = bmi.toFixed(2);
  
    console.log("✅ BMI calculated:", bmiFixed);
    localStorage.setItem("bmi", bmiFixed);
    document.getElementById("bmi-value").innerText = bmiFixed;
    document.getElementById("bmi-result").style.display = "block";
  }
  
  function submitSurvey() {
    const goal = document.getElementById("goal").value;
    console.log("✅ Goal saved:", goal);
    localStorage.setItem("goal", goal);
    window.location.href = "display.html";
  }
  
  const workouts = {
    lean: {
      underweight: ["Light cardio", "Bodyweight"],
      normal: ["HIIT", "Moderate cardio"],
      overweight: ["Heavy cardio", "Circuit"]
    },
    muscular: {
      underweight: ["Lift heavy", "Eat more"],
      normal: ["Strength training"],
      overweight: ["Cut and lift"]
    }
  };
  
  function getBMICategory(bmi) {
    if (bmi < 18.5) return "underweight";
    if (bmi <= 24.9) return "normal";
    return "overweight";
  }
  
  function displayWorkout() {
    const bmi = parseFloat(localStorage.getItem("bmi"));
    const goal = localStorage.getItem("goal");
  
    console.log("🚀 BMI:", bmi);
    console.log("🚀 Goal:", goal);
  
    const display = document.getElementById("workout-display");
  
    if (!bmi || !goal) {
      display.innerHTML = "❌ Missing data.";
      return;
    }
  
    const category = getBMICategory(bmi);
    const plan = workouts[goal][category];
  
    display.innerHTML = `
      <p>BMI: ${bmi} (${category})</p>
      <ul>${plan.map(item => `<li>${item}</li>`).join("")}</ul>
    `;
  }
  
  if (window.location.pathname.includes("display.html")) {
    displayWorkout();
  }
  