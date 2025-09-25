import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card.tsx";
import {Button} from "@/components/ui/button.tsx";
import "../../../../styles/animations.css"

export const IdeaCard = ({title, description, content}: {title: string, description: string, content: string}) => {
    return (
        <Card className="w-full max-w-sm outline transition-all up-on-hover to-purple-on-hover">
            <CardHeader>
                <CardTitle className="text-xl">
                    {title}
                </CardTitle>
                <CardDescription>
                    {description}
                </CardDescription>
            </CardHeader>
            <CardContent>
                {content}
            </CardContent>
            <CardFooter className="flex justify-center gap-2">
                <Button className="cursor-pointer" variant="link">Read docs</Button>
                <Button className="cursor-pointer" variant="link">View source</Button>
            </CardFooter>
        </Card>
    );
};