package com.example.todoapp.presentation.home_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.domain.model.Todo
import com.example.todoapp.presentation.common.taskTextStyle
import com.example.todoapp.ui.theme.TodoAppTheme


@Composable
fun TodoCard(
    todo:Todo,
    onDone:()-> Unit,
    onUpdate:(id:Int)->Unit
){
    Card(modifier = Modifier.fillMaxWidth()) {
        Row (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically)
        {

            IconButton(
                onClick = { onDone()  },
                modifier = Modifier.weight(1f)
            )
            {
                Icon(
                    imageVector = Icons.Rounded.Check ,
                    contentDescription =null
                )

            }

            Text(
                text = todo.task,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = taskTextStyle,
                modifier = Modifier
                    .weight(8f)
                )

            if(todo.isImportant){
                Icon(
                    imageVector = Icons.Rounded.Star ,
                    contentDescription = null,
                    modifier = Modifier.weight(1f)
                )
            }
            IconButton(
                onClick = { onUpdate(todo.id) },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Edit ,
                    contentDescription = null
                )

            }

        }
    }
}

