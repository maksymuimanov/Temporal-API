import './App.css'
import {Main} from "@/components/main/Main.tsx";
import {ThemeProvider} from "@/components/ThemeProvider.tsx";

function App() {
    return (
        <ThemeProvider defaultTheme="system" storageKey="vite-ui-theme">
            <Main />
        </ThemeProvider>
    )
}

export default App