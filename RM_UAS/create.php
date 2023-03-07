<?php
// Include config file
require_once "config.php";

// Define variables and initialize with empty values
$name = $email = $saran = "";
$name_err = $email_err = $saran_err = "";

// Processing form data when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
    // Validate name
    $input_name = trim($_POST["name"]);
    if(empty($input_name)){
        $name_err = "Please enter a name.";
    } elseif(!filter_var($input_name, FILTER_VALIDATE_REGEXP, array("options"=>array("regexp"=>"/^[a-zA-Z\s]+$/")))){
        $name_err = "Please enter a valid name.";
    } else{
        $name = $input_name;
    }

   // Validate address
   $input_email = trim($_POST["email"]);
   if(empty($input_email)){
       $email_err = "Please enter an email.";
   } else{
       $email = $input_email;
   }

    // Validate coment
    $input_saran = trim($_POST["coment"]);
    if(empty($input_saran)){
        $saran_err = "Please enter the coment .";
    } else{
        $saran = $input_saran;
    }

    // Check input errors before inserting in database
    if(empty($name_err) && empty($email_err) && empty($saran_err)){
        // Prepare an insert statement
        $sql = "INSERT INTO pesan (name, email, saran) VALUES (?, ?, ?)";

        if($stmt = mysqli_prepare($link, $sql)){
            // Bind variables to the prepared statement as parameters
            mysqli_stmt_bind_param($stmt, "sss", $param_name, $param_email, $param_saran);

            // Set parameters
            $param_name = $name;
            $param_email = $email;
            $param_saran = $saran;

            // Attempt to execute the prepared statement
            if(mysqli_stmt_execute($stmt)){
                // Records created successfully. Redirect to landing page
                header("location: komentar.php");
                exit();
            } else{
                echo "Something went wrong. Please try again later.";
            }
        }

        // Close statement
        //mysqli_stmt_close($stmt);
    }

    // Close connection
    mysqli_close($link);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tambah Data</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        .wrapper{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h2>Tambah Data</h2>
                    </div>
                    <p>Silahkan isi form di bawah ini kemudian submit untuk menambahkan komentar ke dalam database.</p>
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                        <div class="form-group <?php echo (!empty($name_err)) ? 'has-error' : ''; ?>">
                            <label>Nama</label>
                            <input type="text" name="name" class="form-control" value="<?php echo $name; ?>">
                            <span class="help-block"><?php echo $name_err;?></span>
                        </div>
                        <div class="form-group <?php echo (!empty($email_err)) ? 'has-error' : ''; ?>">
                            <label>Email</label>
                            <textarea name="email" class="form-control"><?php echo $email; ?></textarea>
                            <span class="help-block"><?php echo $email_err;?></span>
                        </div>
                        <div class="form-group <?php echo (!empty($saran_err)) ? 'has-error' : ''; ?>">
                            <label>Saran</label>
                            <textarea name="coment" class="form-control"><?php echo $saran; ?></textarea>
                            
                            <span class="help-block"><?php echo $saran_err;?></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Submit">
                        <a href="index.php" class="btn btn-default">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>