import Vue from "vue";
import {
    Container, Header, Main,
    Menu, MenuItem,
    Input, Form, FormItem,Select, Option, Button, Upload,
    Divider, Dialog, Message,
    Tag
} from "element-ui";

// import ElScrollBar from 'element-ui/lib/scrollbar'

Vue.use(Container).use(Header).use(Main)
    .use(Menu).use(MenuItem)
    .use(Input).use(Form).use(FormItem).use(Select).use(Option).use(Button).use(Upload)
    .use(Divider).use(Dialog)
    .use(Tag)

Vue.prototype.$message = Message;
